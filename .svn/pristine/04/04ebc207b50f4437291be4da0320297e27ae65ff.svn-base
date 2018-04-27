package com.tmtc.utils.EasyuiTree;

import java.util.List;
import java.util.Map;
/**
 * Created:  hbwhypw
 * Date: 2015/9/29 16:27
 * Function: Easyui Tree
 */
public class TreeNode {
    public TreeNode(){
    }

    private String id;
    private String text;//显示的节点文本。
    private boolean checked;//节点是否被选中 为 true为选中
    private String pid;//父ID
    private Map<String,String> attributes;//被添加到节点的自定义属性
    private String target;//目标DOM对象
    private String state;//节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点
    private List<TreeNode> children;//一个节点数组声明了若干节点。

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode [id=" + id + ", text=" + text + ", checked=" + checked
                + ", pid=" + pid + ", attributes=" + attributes + ", target="
                + target + ", children=" + children + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TreeNode other = (TreeNode) obj;
        if (attributes == null) {
            if (other.attributes != null)
                return false;
        } else if (!attributes.equals(other.attributes))
            return false;
        if (checked != other.checked)
            return false;
        if (children == null) {
            if (other.children != null)
                return false;
        } else if (!children.equals(other.children))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pid == null) {
            if (other.pid != null)
                return false;
        } else if (!pid.equals(other.pid))
            return false;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }

    public TreeNode(String id, String text, boolean checked, String pid, Map<String, String> attributes, String target, String state, List<TreeNode> children) {
        this.id = id;
        this.text = text;
        this.checked = checked;
        this.pid = pid;
        this.attributes = attributes;
        this.target = target;
        this.state = state;
        this.children = children;
    }
}
