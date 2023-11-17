Für die volle Funktionalität des Builds über einen Jenkins-Build-Server sowie für ein Kubernetes-Deployment via Helm 
müssen die als TODO-markierten Stellen an den individuellen Bedarf angepasst werden.

Dabei handelt es sich um:
- Definition des Maven Wrapper
- Definition des Jenkinsfile (Build via Jenkins)
- Definition der Image- / Host-Spezifika in der values.yaml (K8s-Deployment via Helm Charts)