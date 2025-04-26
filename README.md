# pay-java
Nkwa Pay SDK for Java 

<!-- Start Summary [summary] -->
## Summary

Nkwa Pay API: Use this API to integrate mobile money across your payment flows, create and manage payments, collections, and disbursements.

Read the docs at https://docs.mynkwa.com/api-reference
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [pay-java](#pay-java)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'io.github.nkwa:pay-sdk:0.1.7'
```

Maven:
```xml
<dependency>
    <groupId>io.github.nkwa</groupId>
    <artifactId>pay-sdk</artifactId>
    <version>0.1.7</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

### Logging
A logging framework/facade has not yet been adopted but is under consideration.

For request and response logging (especially json bodies) use:
```java
SpeakeasyHTTPClient.setDebugLogging(true); // experimental API only (may change without warning)
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
WARNING: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

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

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name         | Type   | Scheme  |
| ------------ | ------ | ------- |
| `apiKeyAuth` | apiKey | API key |

To authenticate with the API the `apiKeyAuth` parameter must be set when initializing the SDK client instance. For example:
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
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [operators()](docs/sdks/operators/README.md)


#### [operators().availability()](docs/sdks/availability/README.md)

* [check](docs/sdks/availability/README.md#check) - Check which operators and operations are currently available.


### [payments()](docs/sdks/payments/README.md)

* [get](docs/sdks/payments/README.md#get) - Get the payment (collection or disbursement) with the specified ID.
* [collect](docs/sdks/payments/README.md#collect) - Collect a payment from a phone number.
* [disburse](docs/sdks/payments/README.md#disburse) - Disburse a payment from your balance to a phone number.

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `get` method throws the following exceptions:

| Error Type                 | Status Code | Content Type     |
| -------------------------- | ----------- | ---------------- |
| models/errors/HttpError    | 401, 404    | application/json |
| models/errors/HttpError    | 500         | application/json |
| models/errors/APIException | 4XX, 5XX    | \*/\*            |

### Example

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
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import io.github.nkwa.pay_sdk.Pay;
import io.github.nkwa.pay_sdk.models.errors.HttpError;
import io.github.nkwa.pay_sdk.models.operations.GetPaymentsIdResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HttpError, HttpError, Exception {

        Pay sdk = Pay.builder()
                .serverURL("https://api.staging.nkwapay.mynkwa.com")
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
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->
