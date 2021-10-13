terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "2.15.0"
    }
  }
}

data "docker_registry_image" "ubuntu" {
  name = "ubuntu:precise"
}


output "docker_registry_image" {
  value = data.docker_registry_image.ubuntu
}