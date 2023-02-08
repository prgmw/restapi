# Getting Started

## Docker
    
    ** Build ** 

        sudo docker build -t prgmw/restapi .
        sudo docker push prgmw/restapi

    ** Remove all container and images ** 

        sudo docker stop $(sudo docker ps -a -q)    
        sudo docker rm $(sudo docker ps -a -q)    
        sudo docker rmi $(sudo docker images -q)
    
    
## K8s

    sudo kubectl logs pod_name    
    sudo kubectl apply -f file.yaml
    sudo kubectl describe deployment deployment_name
    sudo kubectl rollout undo deployment deployment_name
    sudo kubectl delete svc service_name

    ** Create **

        sudo kind create cluster

        sudo kubectl apply -f secret.yaml
        sudo kubectl apply -f manyfest.yaml

        sudo kubectl port-forward svc/restapi-service 8080:8080

    
    ** Remove **
        
        sudo kubectl delete Service restapi-service
        sudo kubectl delete Service mongo-service
        sudo kubectl delete StatefulSet mongo
        sudo kubectl delete Deployment restapi
        sudo kubectl delete Secret mongo-secret  



# mongo

    sudo kubectl exec -it mongo-0 -- mongo -u admin -p --authenticationDatabase admin
    
    use restapi

    db.createUser({ user:'user',pwd:'pass',roles:[ { role:'readWrite', db: 'restapi'}]});
    db.auth('user','pass')  


    
    

    