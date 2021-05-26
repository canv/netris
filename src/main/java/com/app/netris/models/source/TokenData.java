package com.app.netris.models.source;

import com.app.netris.models.ValidatableDataItem;
import com.app.netris.utils.ValidationUtils;

import java.util.Objects;
import java.util.UUID;

public class TokenData implements ValidatableDataItem {
    private UUID value;
    private Long ttl;

    @Override
    public boolean isValid() {
        final boolean isValidValue = ValidationUtils.isValidValue(this.value);
        final boolean isValidTtl = ValidationUtils.isValidTtl(this.ttl);
        return isValidValue && isValidTtl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenData tokenData = (TokenData) o;
        return Objects.equals(value, tokenData.value) && Objects.equals(ttl, tokenData.ttl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, ttl);
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}
