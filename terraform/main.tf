# 1. 3-Tier Multi-AZ VPC Network
module "vpc" {
  source      = "./modules/vpc"
  environment = var.environment
  vpc_cidr    = var.vpc_cidr
}

# 2. Chained Zero-Trust Security Groups
module "security" {
  source      = "./modules/security"
  environment = var.environment
  vpc_id      = module.vpc.vpc_id
}

# 3. Amazon ECR Private Registries
module "ecr" {
  source      = "./modules/ecr"
  environment = var.environment
}

# 4. AWS RDS PostgreSQL in Isolated Subnets
module "rds" {
  source                 = "./modules/rds"
  environment            = var.environment
  database_subnet_ids    = module.vpc.database_subnet_ids
  rds_security_group_id  = module.security.rds_security_group_id
  db_username            = var.db_username
  db_password            = var.db_password
}

# 5. AWS EKS Cluster with Private Worker Nodes
module "eks" {
  source             = "./modules/eks"
  environment        = var.environment
  vpc_id             = module.vpc.vpc_id
  public_subnet_ids  = module.vpc.public_subnet_ids
  private_subnet_ids = module.vpc.private_subnet_ids
  instance_type      = var.eks_instance_type
}
