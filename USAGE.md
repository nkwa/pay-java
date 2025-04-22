<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import io.github.nkwa.pay_sdk.Pay;
import io.github.nkwa.pay_sdk.models.errors.HttpError;
import io.github.nkwa.pay_sdk.models.operations.GetPaymentsIdResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HttpError, HttpError, Exception {

        Pay sdk = Pay.builder()
                .apiKeyAuth("<YOUR_API_KEY_HERE>")
            .build();

        GetPaymentsIdResponse res = sdk.payments().get()
                .id("96e9ed79-9fef-44a6-9435-0625338ca86a")
                .call();

        if (res.payment().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->