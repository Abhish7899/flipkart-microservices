variable "environment" {
  description = "Environment identifier"
  type        = string
}

variable "services" {
  description = "List of microservices to create ECR repositories for"
  type        = list(string)
  default = [
    "api-gateway",
    "product-service",
    "user-service",
    "service-registry",
    "ui-service"
  ]
}
