package com.example.MongoReactive.documents;

public class Factory {
    private String name;
    private String country;
    private boolean importado;

    public Factory() {
    }

    public Factory(String name, String country, boolean importado) {
        this.name = name;
        this.country = country;
        this.importado = importado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
}
