module core.model {
    requires transitive java.money;

    exports com.pharmaplus.core.model;
    exports com.pharmaplus.core.repository;

    opens com.pharmaplus.core.model to gson;
}