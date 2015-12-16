package k0n9.module.auth.entity;

/**
 * @author David Kong
 * @version 1.0
 */
public enum OrganizationType {

    bloc("集团"), branch_office("分公司"), department("部门"), group("部门小组");

    private final String info;

    OrganizationType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}