variable "aws_region" {
  description = "The AWS Region to deploy resources into"
  type        = string
  default     = "us-east-2"
}

variable "environment" {
  description = "Environment identifier"
  type        = string
  default     = "flipkart-dev"
}

variable "vpc_cidr" {
  description = "Base CIDR block for the custom VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "db_username" {
  description = "Master username for RDS PostgreSQL"
  type        = string
  default     = "postgres"
}

variable "db_password" {
  description = "Master password for RDS PostgreSQL"
  type        = string
  sensitive   = true
  default     = "FlipkartDev2026Secure!"
}

variable "eks_instance_type" {
  description = "EC2 instance type for EKS worker nodes"
  type        = string
  default     = "t3.medium"
}
