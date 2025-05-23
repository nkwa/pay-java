/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.github.nkwa.pay_sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.nkwa.pay_sdk.utils.SpeakeasyMetadata;
import io.github.nkwa.pay_sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class GetPaymentsIdRequest {

    /**
     * ID of payment to fetch
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=id")
    private String id;

    @JsonCreator
    public GetPaymentsIdRequest(
            String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
    }

    /**
     * ID of payment to fetch
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * ID of payment to fetch
     */
    public GetPaymentsIdRequest withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
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
        GetPaymentsIdRequest other = (GetPaymentsIdRequest) o;
        return 
            Objects.deepEquals(this.id, other.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            id);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPaymentsIdRequest.class,
                "id", id);
    }
    
    public final static class Builder {
 
        private String id;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * ID of payment to fetch
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }
        
        public GetPaymentsIdRequest build() {
            return new GetPaymentsIdRequest(
                id);
        }
    }
}
