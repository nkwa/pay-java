# Availability
(*operators().availability()*)

## Overview

### Available Operations

* [check](#check) - Check which operators and operations are currently available.

## check

Check which operators and operations are currently available.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import org.nkwa.pay.pay_sdk.Pay;
import org.nkwa.pay.pay_sdk.models.errors.HttpError;
import org.nkwa.pay.pay_sdk.models.operations.GetAvailabilityResponse;

public class Application {

    public static void main(String[] args) throws HttpError, HttpError, Exception {

        Pay sdk = Pay.builder()
                .apiKeyAuth("<YOUR_API_KEY_HERE>")
            .build();

        GetAvailabilityResponse res = sdk.operators().availability().check()
                .call();

        if (res.availabilities().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetAvailabilityResponse](../../models/operations/GetAvailabilityResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/HttpError    | 401                        | application/json           |
| models/errors/HttpError    | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |