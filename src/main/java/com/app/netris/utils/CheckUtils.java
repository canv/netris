package com.app.netris.utils;

import com.app.netris.exceptions.DataItemInvalidException;
import com.app.netris.exceptions.DataItemNotFoundException;
import com.app.netris.exceptions.IdInvalidSupportException;
import com.app.netris.models.ValidatableDataItem;

public class CheckUtils {

    public static void dataItemCheck(final ValidatableDataItem validatableDataItem) {
        if (validatableDataItem == null) {
            throw new DataItemNotFoundException("Data not found");
        }
        if (!validatableDataItem.isValid()) {
            throw new DataItemInvalidException("Invalid camera object values, check content");
        }
    }

    public static void idCheck(final Long id) {
        if (!ValidationUtils.isValidId(id)) {
            throw new IdInvalidSupportException(String.format("Invalid camera id: %s", id));
        }
    }
}
