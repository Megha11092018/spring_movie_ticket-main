# ☁️ Project Overview

This project demonstrates the deployment of a **Spring Boot Movie Ticket Booking Application** on **AWS Cloud** using a secure **Virtual Private Cloud (VPC)** architecture. The application is containerized with Docker, orchestrated using Docker Compose, and deployed automatically through a Jenkins CI/CD pipeline.

The infrastructure consists of an EC2 instance inside a custom VPC, where Jenkins builds the application, Docker creates containers, and MySQL runs as a separate service. Jenkins fetches the latest code from GitHub, builds Docker images, and deploys the application automatically.

---

# 🏗️ AWS Infrastructure

* AWS VPC
* Public Subnet
* Internet Gateway
* Route Table
* Security Groups
* EC2 Ubuntu Instance
* Jenkins Server
* Docker Engine
* Docker Compose
* Spring Boot Application
* MySQL Database

---

# 📐 Architecture

```
                        GitHub Repository
                               │
                               ▼
                        Jenkins Pipeline
                               │
                               ▼
                      Docker Compose Build
                               │
         ┌─────────────────────┴─────────────────────┐
         ▼                                           ▼
 Spring Boot Container                      MySQL Container
         │                                           │
         └─────────────────────┬─────────────────────┘
                               │
                         AWS EC2 Instance
                               │
                     Inside Custom AWS VPC
                               │
                     Internet Gateway (IGW)
                               │
                               ▼
                           End User
```

---

# 🌐 AWS Network Architecture

```
AWS Cloud
│
└── Custom VPC (10.0.0.0/16)
    │
    ├── Public Subnet
    │     │
    │     ├── EC2 Ubuntu
    │     │      ├── Jenkins
    │     │      ├── Docker
    │     │      ├── Spring Boot
    │     │      └── MySQL Container
    │     │
    │     └── Elastic/Public IP
    │
    ├── Route Table
    │
    ├── Internet Gateway
    │
    └── Security Group
          ├── 22 (SSH)
          ├── 8085 (Spring Boot)
          ├── 8080 (Jenkins)
          └── 3306 (MySQL)
```

---

# 🔧 AWS Services Used

* Amazon VPC
* Amazon EC2
* Security Groups
* Internet Gateway
* Route Tables
* Ubuntu 26.04 LTS
* Jenkins
* Docker
* Docker Compose
* GitHub

---

# 🔥 Additional Troubleshooting Faced

### 11. VPC Network Configuration

**Problem**

Unable to access Jenkins and the Spring Boot application from the browser.

**Solution**

* Configured Internet Gateway.
* Associated the Route Table with the Public Subnet.
* Added a default route (`0.0.0.0/0`) to the Internet Gateway.
* Assigned a Public IPv4 address to the EC2 instance.

---

### 12. Security Group Configuration

**Problem**

Application and Jenkins were inaccessible.

**Solution**

Opened the required inbound ports:

| Port | Purpose                 |
| ---- | ----------------------- |
| 22   | SSH                     |
| 8080 | Jenkins                 |
| 8085 | Spring Boot Application |
| 3306 | MySQL                   |

---

### 13. Jenkins Pipeline Repository Issue

**Problem**

The Jenkins pipeline was initially configured to pull from an incorrect GitHub repository, causing outdated pipeline scripts to execute.

**Solution**

Created a new Jenkins pipeline pointing to the correct GitHub repository and verified the updated Jenkinsfile.

---

# 🚀 DevOps Workflow

```
Developer
     │
     ▼
 GitHub Repository
     │
     ▼
 Jenkins Pipeline
     │
     ▼
 Docker Build
     │
     ▼
 Docker Compose
     │
     ▼
 Spring Boot + MySQL Containers
     │
     ▼
 AWS EC2 (Inside Custom VPC)
     │
     ▼
 Browser
```


# 🛠️ Common Errors Faced & Troubleshooting

During the deployment and CI/CD implementation of this project, the following issues were encountered and resolved.

---

## 1. ❌ `docker-compose: command not found`

### Cause
Docker Compose V1 was not installed. The system was using Docker Compose V2.

### Verification

```bash
docker compose version
```

### Solution

```bash
sudo apt update
sudo apt install docker-compose-v2 -y
```

---

## 2. ❌ Jenkins Permission Denied While Accessing Docker

### Error

```text
permission denied while trying to connect to the Docker daemon socket
```

### Solution

```bash
sudo usermod -aG docker jenkins
sudo systemctl restart docker
sudo systemctl restart jenkins
```

---

## 3. ❌ Verify Jenkins User Docker Access

### Commands Used

```bash
sudo su - jenkins
docker compose version
docker ps
```

---

## 4. ❌ Verify Docker Containers

### Commands Used

```bash
docker ps
docker ps -a
docker images
docker logs spring_movie_ticket_app
docker logs spring_movie_ticket_mysql
```

---

## 5. ❌ GitHub Authentication Failed

### Error

```text
remote: Invalid username or token.
Password authentication is not supported for Git operations.
```

### Verification Commands

```bash
git remote -v
git status
git log --oneline
```

### Solution

- Verified the remote GitHub repository.
- Updated Jenkins to use the correct GitHub repository.
- Used GitHub Personal Access Token (PAT) or SSH for Git operations instead of password authentication.

---

## 6. ❌ Verify Docker Compose Configuration

### Commands Used

```bash
cat docker-compose.yml
```

Verified:
- Service configuration
- Port mappings
- Environment variables
- Volume mappings
- Health check configuration

---

## 7. ❌ Verify Jenkins Pipeline Configuration

### Commands Used

```bash
cat Jenkinsfile
grep -n "docker" Jenkinsfile
```

Verified:
- Docker Compose command
- Pipeline stages
- Deploy and Remove actions
- Jenkins pipeline syntax

---

## 8. ❌ Spring Boot Container Health Check

### Commands Used

```bash
docker ps
docker logs spring_movie_ticket_app
docker inspect spring_movie_ticket_app
```

### Verification

Confirmed that:
- Spring Boot application started successfully.
- MySQL container was healthy.
- Tomcat was running on port **8085**.
- Docker health check configuration required review.

---

## 9. ❌ Application Accessibility

### Commands Used

```bash
curl http://localhost:8085
curl ifconfig.me
sudo ss -tulnp | grep 8085
sudo ufw status
```

### Verification

- Verified application was accessible locally.
- Confirmed EC2 public IP.
- Checked listening ports.
- Verified Security Group and firewall configuration.

---

## 10. ❌ Jenkins Workspace Verification

### Commands Used

```bash
ls /var/lib/jenkins/workspace
cat /var/lib/jenkins/workspace/maven/Jenkinsfile
cat /var/lib/jenkins/workspace/app/Jenkinsfile
```

### Verification

Confirmed Jenkins was using the correct workspace and the latest Jenkinsfile from the GitHub repository.

---

## ✅ Key Troubleshooting Commands

```bash
# Docker
docker compose version
docker compose up -d --build
docker compose down
docker ps
docker logs spring_movie_ticket_app

# Jenkins
sudo systemctl restart jenkins
sudo systemctl status jenkins
sudo journalctl -u jenkins -f

# Git
git remote -v
git status
git log --oneline

# Network
curl http://localhost:8085
curl ifconfig.me
sudo ss -tulnp | grep 8085

# Configuration Files
cat docker-compose.yml
cat Jenkinsfile
grep -n "docker" Jenkinsfile
```

---

### This version is much more professional because it highlights that you worked with:

* ✅ AWS VPC
* ✅ Public Subnet
* ✅ Route Table
* ✅ Internet Gateway
* ✅ Security Groups
* ✅ EC2
* ✅ Jenkins CI/CD
* ✅ Docker
* ✅ Docker Compose
* ✅ Spring Boot
* ✅ MySQL
* ✅ GitHub Integration

### Developed by : 
Megha B Biradar

