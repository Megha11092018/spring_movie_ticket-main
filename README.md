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



