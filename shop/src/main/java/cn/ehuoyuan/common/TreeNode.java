/**
 * 
 */
package cn.ehuoyuan.common;

import java.util.List;

/**
 * zTree生成树形结构所需的模型
 * @author ouyangfeng
 * @date 2017-10-1 16:22:23
 * @version 1.0
 */
public class TreeNode {
	
	private String id ;
	private String name ;//显示的文本
	private List<TreeNode> children ;//子节点
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	

}
