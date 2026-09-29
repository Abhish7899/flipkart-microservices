terraform {
  backend "s3" {
    bucket         = "flipkart-tf-state-abhish-2026"
    key            = "dev/flipkart-microservices.tfstate"
    region         = "us-east-2"
    dynamodb_table = "flipkart-tf-lock"
    encrypt        = true
  }
}
