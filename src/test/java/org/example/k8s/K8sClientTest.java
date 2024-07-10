package org.example.k8s;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Scale;
import io.kubernetes.client.openapi.models.V1ScaleSpec;
import io.kubernetes.client.util.Config;
import org.junit.jupiter.api.Test;

public class K8sClientTest {

    @Test
    public void test() {
        try {
            // Настроить подключение к Kubernetes API
            ApiClient client = Config.defaultClient();
            Configuration.setDefaultApiClient(client);

            // Создать экземпляр AppsV1Api для работы с деплоями
            AppsV1Api apiInstance = new AppsV1Api(client);

            // Указать namespace и имя деплоя
            String namespace = "default"; // Замените на ваш namespace
            String deploymentName = "simple-nginx-588f84876f-f4clx"; // Замените на имя вашего деплоя

            // Задать новое количество реплик

            int newReplicaCount = 4;
            V1Scale scale = new V1Scale();
            V1ScaleSpec scaleSpec = new V1ScaleSpec();
            scaleSpec.setReplicas(newReplicaCount);
            scale.setSpec(scaleSpec);

            // Установка метаданных для V1Scale
            V1ObjectMeta metadata = new V1ObjectMeta();
            metadata.setName(deploymentName);
            metadata.setNamespace(namespace);
            scale.setMetadata(metadata);

            // Обновить деплой
            V1Scale result = apiInstance.replaceNamespacedDeploymentScale(deploymentName, namespace, scale, null, null, null);
            System.out.println("Successfully scaled the deployment to " + newReplicaCount + " replicas.");
        } catch (ApiException e) {
            System.err.println("ApiException when calling AppsV1Api#replaceNamespacedDeploymentScale");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
