#!/bin/bash
# ==============================================================================
# Flipkart Microservices - Automated 1-Click AWS EC2 Deployment Script
# ==============================================================================

set -e

echo "🚀 [1/5] Checking and Installing System Dependencies (Docker & Docker Compose)..."
sudo apt-get update -y
sudo apt-get install -y ca-certificates curl gnupg lsb-release git

if ! command -v docker &> /dev/null; then
    echo "📦 Installing Docker Engine..."
    sudo mkdir -p /etc/apt/keyrings
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
    echo \
      "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
      $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt-get update -y
    sudo apt-get install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin
    sudo systemctl enable docker
    sudo systemctl start docker
    sudo usermod -aG docker $USER
fi

echo "🐳 [2/5] Verifying Docker Installation..."
docker --version

echo "⚙️ [3/5] Setting up Environment & Permissions..."
chmod +x ./docker/postgres/init-dbs.sh || true

echo "🔨 [4/5] Building & Launching Microservices Containers with Docker Compose..."
# Stop any previously running containers
docker compose -f docker-compose.aws.yml down --remove-orphans || true

# Build and start all services in detached mode
docker compose -f docker-compose.aws.yml up -d --build

echo "⏳ [5/5] Waiting for Microservices to initialize..."
sleep 25

# Get Public IP of EC2 Instance
PUBLIC_IP=$(curl -s http://169.254.169.254/latest/meta-data/public-ipv4 || curl -s ifconfig.me || echo "localhost")

echo "=============================================================================="
echo "🎉 DEPLOYMENT SUCCESSFUL!"
echo "=============================================================================="
echo "🌐 Your Flipkart Application is now LIVE on AWS:"
echo "👉 http://${PUBLIC_IP}"
echo ""
echo "📊 Eureka Service Registry Dashboard:"
echo "👉 http://${PUBLIC_IP}:8761"
echo ""
echo "📦 Product Catalog API:"
echo "👉 http://${PUBLIC_IP}:8082/api/products"
echo ""
echo "👤 User & Auth API:"
echo "👉 http://${PUBLIC_IP}:8081/api/users/health"
echo "=============================================================================="
