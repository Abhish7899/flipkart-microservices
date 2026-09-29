#!/usr/bin/env python3
import time
import urllib.request
import urllib.error
import threading
from concurrent.futures import ThreadPoolExecutor

TARGET_RPS = 100
DURATION_SECONDS = 60
ENDPOINTS = [
    "http://127.0.0.1/api/products",
    "http://127.0.0.1/",
    "http://127.0.0.1/api/products"
]

total_sent = 0
total_success = 0
total_errors = 0
lock = threading.Lock()

def send_request(url):
    global total_success, total_errors
    try:
        req = urllib.request.Request(url, headers={'User-Agent': 'FlipkartLoadTester/1.0'})
        with urllib.request.urlopen(req, timeout=5) as resp:
            _ = resp.read()
            with lock:
                total_success += 1
    except Exception as e:
        with lock:
            total_errors += 1

print(f"🚀 Starting HTTP Load Generator...")
print(f"Target: {TARGET_RPS} requests/second")
print(f"Duration: {DURATION_SECONDS} seconds (~{TARGET_RPS * DURATION_SECONDS} total requests)")
print(f"Endpoints: {ENDPOINTS}")
print("-" * 60)

start_time = time.time()
executor = ThreadPoolExecutor(max_workers=50)

try:
    for second in range(DURATION_SECONDS):
        sec_start = time.time()
        for i in range(TARGET_RPS):
            url = ENDPOINTS[(second * TARGET_RPS + i) % len(ENDPOINTS)]
            executor.submit(send_request, url)
            with lock:
                total_sent += 1
            # Micro-sleep to spread the 100 requests evenly over the 1 second
            time.sleep(1.0 / (TARGET_RPS * 1.05))

        elapsed_sec = time.time() - sec_start
        if elapsed_sec < 1.0:
            time.sleep(1.0 - elapsed_sec)

        with lock:
            current_elapsed = time.time() - start_time
            actual_rps = total_sent / current_elapsed if current_elapsed > 0 else 0
            print(f"[{int(current_elapsed):02d}s/{DURATION_SECONDS}s] Sent: {total_sent} | Success: {total_success} | Errors: {total_errors} | Live RPS: {actual_rps:.1f} req/s")

finally:
    executor.shutdown(wait=True)

total_time = time.time() - start_time
print("-" * 60)
print(f"🏁 Load Generation Complete!")
print(f"Total Requests: {total_sent}")
print(f"Successful Requests: {total_success}")
print(f"Failed Requests: {total_errors}")
print(f"Average Throughput: {total_sent / total_time:.2f} req/s")
print(f"Total Duration: {total_time:.2f}s")
