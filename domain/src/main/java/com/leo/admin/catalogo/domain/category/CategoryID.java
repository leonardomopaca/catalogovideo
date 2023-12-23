package com.leo.admin.catalogo.domain.category;

import com.leo.admin.catalogo.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(final String value) {
        //Adding Constraint
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique(){
//        return new CategoryID(UUID.randomUUID().toString().toLowerCase());
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(final String value){
        return new CategoryID(value);
    }

    public static CategoryID from(final UUID uuid){
        return new CategoryID(uuid.toString().toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
