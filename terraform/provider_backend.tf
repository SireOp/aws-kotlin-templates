terrafom {
    required_version = ">= 1.6.0"

    required_proiders {
        aws = {
            source = "hashicorp/aws"
            version = "-> 5.0"
        }
    }


# Terrafrom state in S3
    backend "s3" {
        bucket         = "YOUR-TF-STATE-BUCKET-NAME"
        key            = "envs/dev/aws-infra.tfstate"
        region         = "us-east-2"
        dynamodb_table = "tf-state-locks"
        encrypt        = true    
    }
}

provider "aws" {
    region = var.aws_region
}

variable "aws_region" {
  description = "AWS region to deploy into"
  type        = string
  default     = "us-east-2"
}