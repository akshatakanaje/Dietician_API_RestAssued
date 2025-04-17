package enumclass;

public enum APIEndpoints {

    userLogin("/login"),
    invalidLoginEndpoint("/login/"),
    userLogout("/logoutdietician"),
    invalid_userLogout("/logoutDie"),
    createDietician("/dietician"),
    getALlDietician("/dietician"),
    getDieticianById("/dietician/{dieticianId}"),
    updateDietician("/dietician/{dieticianId}"),
    deleteDieticianById("/dietician/{dieticianId}");

    private String resource;

    APIEndpoints(String resource) {
        this.resource=resource;
    }

    public String getResource() {
        return resource;
    }


}
