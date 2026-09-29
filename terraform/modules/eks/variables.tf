variable "environment" {
  description = "Environment identifier"
  type        = string
}

variable "vpc_id" {
  description = "VPC ID where EKS will be launched"
  type        = string
}

variable "private_subnet_ids" {
  description = "Private Subnet IDs for EKS worker nodes"
  type        = list(string)
}

variable "public_subnet_ids" {
  description = "Public Subnet IDs for EKS control plane interfaces"
  type        = list(string)
}

variable "instance_type" {
  description = "EC2 instance type for worker nodes"
  type        = string
  default     = "t3.medium"
}
