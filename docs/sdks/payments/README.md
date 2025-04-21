# Payments
(*payments()*)

## Overview

### Available Operations

* [get](#get) - Get the payment (collection or disbursement) with the specified ID.
* [collect](#collect) - Collect a payment from a phone number.
* [disburse](#disburse) - Disburse a payment from your balance to a phone number.

## get

Get the payment (collection or disbursement) with the specified ID.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import org.nkwa.pay.pay_sdk.Pay;
import org.nkwa.pay.pay_sdk.models.errors.HttpError;
import org.nkwa.pay.pay_sdk.models.operations.GetPaymentsIdResponse;

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

### Parameters

| Parameter              | Type                   | Required               | Description            |
| ---------------------- | ---------------------- | ---------------------- | ---------------------- |
| `id`                   | *String*               | :heavy_check_mark:     | ID of payment to fetch |

### Response

**[GetPaymentsIdResponse](../../models/operations/GetPaymentsIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/HttpError    | 401, 404                   | application/json           |
| models/errors/HttpError    | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## collect

Collect a payment from a phone number.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import org.nkwa.pay.pay_sdk.Pay;
import org.nkwa.pay.pay_sdk.models.components.PaymentRequest;
import org.nkwa.pay.pay_sdk.models.errors.HttpError;
import org.nkwa.pay.pay_sdk.models.operations.PostCollectResponse;

public class Application {

    public static void main(String[] args) throws HttpError, HttpError, Exception {

        Pay sdk = Pay.builder()
                .apiKeyAuth("<YOUR_API_KEY_HERE>")
            .build();

        PaymentRequest req = PaymentRequest.builder()
                .amount(433642L)
                .phoneNumber("237650000000")
                .build();

        PostCollectResponse res = sdk.payments().collect()
                .request(req)
                .call();

        if (res.payment().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [PaymentRequest](../../models/shared/PaymentRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[PostCollectResponse](../../models/operations/PostCollectResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/HttpError    | 400, 401, 403              | application/json           |
| models/errors/HttpError    | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## disburse

Disburse a payment from your balance to a phone number.

### Example Usage

```java
package hello.world;

import java.lang.Exception;
import org.nkwa.pay.pay_sdk.Pay;
import org.nkwa.pay.pay_sdk.models.components.PaymentRequest;
import org.nkwa.pay.pay_sdk.models.errors.HttpError;
import org.nkwa.pay.pay_sdk.models.operations.PostDisburseResponse;

public class Application {

    public static void main(String[] args) throws HttpError, HttpError, Exception {

        Pay sdk = Pay.builder()
                .apiKeyAuth("<YOUR_API_KEY_HERE>")
            .build();

        PaymentRequest req = PaymentRequest.builder()
                .amount(410119L)
                .phoneNumber("237650000000")
                .build();

        PostDisburseResponse res = sdk.payments().disburse()
                .request(req)
                .call();

        if (res.payment().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [PaymentRequest](../../models/shared/PaymentRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[PostDisburseResponse](../../models/operations/PostDisburseResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/HttpError    | 400, 401, 403              | application/json           |
| models/errors/HttpError    | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |