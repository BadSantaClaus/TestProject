package org.example.k8s;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpec;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class Fabric8Test {

    @Test
    public void fabric8Test() throws IOException {
        String namespace = "default";
        String deploymentName = "simple-nginx-588f84876f-f4clx";
        int newReplicaCount = 2;

        String kubeconfigContents = Files.readString(Path.of("src/main/resources/config.yaml"));
        Config config = Config.fromKubeconfig(kubeconfigContents);

        try (KubernetesClient client = new KubernetesClientBuilder().withConfig(config).build()) {
            Deployment deployment = client.apps().deployments().inNamespace(namespace).withName(deploymentName).get();
            DeploymentSpec spec = deployment.getSpec();
            spec.setReplicas(newReplicaCount);

            client.apps().deployments().inNamespace(namespace).withName(deploymentName).patch(deployment);
            System.out.println("Successfully scaled the deployment to " + newReplicaCount + " replicas.");
        }
    }
}
