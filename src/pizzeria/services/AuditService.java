package pizzeria.services;

class AuditService {
    static void audit(String actionName){
        FileService.audit(actionName);
    }
}