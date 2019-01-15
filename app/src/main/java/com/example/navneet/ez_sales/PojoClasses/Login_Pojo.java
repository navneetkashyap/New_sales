package com.example.navneet.ez_sales.PojoClasses;

public class Login_Pojo {


    /**
     * status : 0
     * message : Authenticated
     * result : {"sessionId":60,"userRole":"EXECUTIVE"}
     * page : null
     */

    private int status;
    private String message;
    private ResultBean result;
    private Object page;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public static class ResultBean {
        /**
         * sessionId : 60
         * userRole : EXECUTIVE
         */

        private int sessionId;
        private String userRole;

        public int getSessionId() {
            return sessionId;
        }

        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserRole() {
            return userRole;
        }

        public void setUserRole(String userRole) {
            this.userRole = userRole;
        }
    }
}
