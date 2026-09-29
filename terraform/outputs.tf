output "vpc_id" {
  description = "The ID of the custom VPC"
  value       = module.vpc.vpc_id
}

output "ecr_repositories" {
  description = "URLs of the created Amazon ECR repositories"
  value       = module.ecr.repository_urls
}

output "rds_endpoint" {
  description = "Connection endpoint for PostgreSQL"
  value       = module.rds.endpoint
}

output "eks_cluster_name" {
  description = "The name of the EKS cluster"
  value       = module.eks.cluster_name
}

output "eks_cluster_endpoint" {
  description = "The API endpoint of the EKS cluster"
  value       = module.eks.cluster_endpoint
}

output "configure_kubectl_command" {
  description = "Command to configure local kubectl to connect to the new EKS cluster"
  value       = "aws eks --region ${var.aws_region} update-kubeconfig --name ${module.eks.cluster_name}"
}
