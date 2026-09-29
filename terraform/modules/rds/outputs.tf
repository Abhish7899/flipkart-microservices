output "endpoint" {
  description = "Connection endpoint for PostgreSQL"
  value       = aws_db_instance.postgres.endpoint
}

output "address" {
  description = "Hostname of the database"
  value       = aws_db_instance.postgres.address
}

output "port" {
  description = "Port the database listens on"
  value       = aws_db_instance.postgres.port
}

output "database_name" {
  description = "Initial database name"
  value       = aws_db_instance.postgres.db_name
}
