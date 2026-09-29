import json
import urllib.request
import urllib.error
import base64

with open('/home/ubuntu/flipkart-overview.json', 'r', encoding='utf-8') as f:
    dashboard_data = json.load(f)

payload = json.dumps({
    "dashboard": dashboard_data,
    "overwrite": True
}).encode('utf-8')

auth = base64.b64encode(b"admin:FlipkartAdmin2026!").decode('ascii')
headers = {
    'Content-Type': 'application/json',
    'Authorization': f'Basic {auth}'
}

# 1. Post Dashboard
req = urllib.request.Request(
    'http://127.0.0.1:3000/api/dashboards/db',
    data=payload,
    headers=headers
)

try:
    with urllib.request.urlopen(req) as response:
        result = response.read().decode('utf-8')
        print("DASHBOARD IMPORT SUCCESS:", response.status, result)
except urllib.error.HTTPError as e:
    print("DASHBOARD IMPORT FAILED:", e.code, e.read().decode('utf-8'))

# 2. Set as default home dashboard
pref_payload = json.dumps({
    "homeDashboardUID": "flipkart-prod-monitoring"
}).encode('utf-8')

pref_req = urllib.request.Request(
    'http://127.0.0.1:3000/api/org/preferences',
    data=pref_payload,
    headers=headers,
    method='PUT'
)

try:
    with urllib.request.urlopen(pref_req) as response:
        print("ORG HOME PREFERENCE SET:", response.status, response.read().decode('utf-8'))
except urllib.error.HTTPError as e:
    print("ORG PREFERENCE FAILED:", e.code, e.read().decode('utf-8'))

# 3. Also set for current user
user_pref_req = urllib.request.Request(
    'http://127.0.0.1:3000/api/user/preferences',
    data=pref_payload,
    headers=headers,
    method='PUT'
)

try:
    with urllib.request.urlopen(user_pref_req) as response:
        print("USER HOME PREFERENCE SET:", response.status, response.read().decode('utf-8'))
except urllib.error.HTTPError as e:
    print("USER PREFERENCE FAILED:", e.code, e.read().decode('utf-8'))
