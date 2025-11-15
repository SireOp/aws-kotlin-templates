variable "bucket_name" {
    description = "Name of the S3 bucket"
    type        = map(string)
    default     ={}
}

resource "aws_s3_bucket" "this" {
    bucket = var.bucket_name

    tags = merge(
        var.tags,
    {
        "ManagedBy" = "Terrafrom"
    }
    )
}

output "bucket_name" {
    value = aws_s3_bucket.this.bucket
}