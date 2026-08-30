package dev.deployhub.catalog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalog_applications")
public class CatalogApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private String version;
    private String icon;

    protected CatalogApplication() {}

    public CatalogApplication(String name, String description, String category, String version, String icon) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.version = version;
        this.icon = icon;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getVersion() { return version; }
    public String getIcon() { return icon; }
}

