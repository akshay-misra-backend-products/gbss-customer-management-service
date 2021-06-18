package com.gbss.customer.rest.json.request;

import com.gbss.common.api.model.Characteristic;
import com.gbss.customer.api.model.contants.ContactType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class ContactMedium {

    private String id;

    private boolean preferred;

    private ContactType type;

    private List<Characteristic> characteristic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactMedium)) return false;
        ContactMedium that = (ContactMedium) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
