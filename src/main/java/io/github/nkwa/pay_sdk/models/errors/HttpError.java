/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.github.nkwa.pay_sdk.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nkwa.pay_sdk.utils.Utils;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("serial")
public class HttpError extends RuntimeException {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("details")
    private Optional<? extends List<Object>> details;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("message")
    private Optional<String> message;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("statusCode")
    private Optional<Long> statusCode;

    @JsonCreator
    public HttpError(
            @JsonProperty("details") Optional<? extends List<Object>> details,
            @JsonProperty("message") Optional<String> message,
            @JsonProperty("statusCode") Optional<Long> statusCode) {
        super(message.orElse(null));
        Utils.checkNotNull(details, "details");
        Utils.checkNotNull(message, "message");
        Utils.checkNotNull(statusCode, "statusCode");
        this.details = details;
        this.message = message;
        this.statusCode = statusCode;
    }
    
    public HttpError() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Object>> details() {
        return (Optional<List<Object>>) details;
    }

    @JsonIgnore
    public Optional<String> message() {
        return message;
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return Utils.valueOrNull(message);
    }

    @JsonIgnore
    public Optional<Long> statusCode() {
        return statusCode;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public HttpError withDetails(List<Object> details) {
        Utils.checkNotNull(details, "details");
        this.details = Optional.ofNullable(details);
        return this;
    }

    public HttpError withDetails(Optional<? extends List<Object>> details) {
        Utils.checkNotNull(details, "details");
        this.details = details;
        return this;
    }

    public HttpError withMessage(String message) {
        Utils.checkNotNull(message, "message");
        this.message = Optional.ofNullable(message);
        return this;
    }

    public HttpError withMessage(Optional<String> message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
        return this;
    }

    public HttpError withStatusCode(long statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = Optional.ofNullable(statusCode);
        return this;
    }

    public HttpError withStatusCode(Optional<Long> statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HttpError other = (HttpError) o;
        return 
            Objects.deepEquals(this.details, other.details) &&
            Objects.deepEquals(this.message, other.message) &&
            Objects.deepEquals(this.statusCode, other.statusCode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            details,
            message,
            statusCode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(HttpError.class,
                "details", details,
                "message", message,
                "statusCode", statusCode);
    }
    
    public final static class Builder {
 
        private Optional<? extends List<Object>> details = Optional.empty();
 
        private Optional<String> message = Optional.empty();
 
        private Optional<Long> statusCode = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder details(List<Object> details) {
            Utils.checkNotNull(details, "details");
            this.details = Optional.ofNullable(details);
            return this;
        }

        public Builder details(Optional<? extends List<Object>> details) {
            Utils.checkNotNull(details, "details");
            this.details = details;
            return this;
        }

        public Builder message(String message) {
            Utils.checkNotNull(message, "message");
            this.message = Optional.ofNullable(message);
            return this;
        }

        public Builder message(Optional<String> message) {
            Utils.checkNotNull(message, "message");
            this.message = message;
            return this;
        }

        public Builder statusCode(long statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = Optional.ofNullable(statusCode);
            return this;
        }

        public Builder statusCode(Optional<Long> statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }
        
        public HttpError build() {
            return new HttpError(
                details,
                message,
                statusCode);
        }
    }
}

