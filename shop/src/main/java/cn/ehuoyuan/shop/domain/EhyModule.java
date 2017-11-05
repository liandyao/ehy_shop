package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 模块管理
 */
public class EhyModule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7383850896153730791L;
	//模块ID
	private String modId;
	//上级_模块ID
	private String ehyModId;
	//模块URL
	private String url;
	//模块名称
	private String modName;
	//模块编码
	private String modCode;
	//模块说明
	private String modDesc;
	//是否有效
	private Integer isva;
	//操作时间
	private Date optime;
	//操作人
	private String oper;
	//排序
	private Integer sort;
	//下级模块集合
	private List<EhyModule> moduleList;
	//上级模块
	private EhyModule module;
	//上级模块名称
	private String ehyModName;
	
	public String getEhyModName() {
		if(module!=null){
			ehyModName=module.getModName();
		}
		return ehyModName;
	}
	public void setEhyModName(String ehyModName) {
		this.ehyModName = ehyModName;
	}
	/**
	 * 
	 * @return 下级模块集合
	 */
	public List<EhyModule> getModuleList() {
		return moduleList;
	}
	/**
	 * 
	 * @param 下级模块集合
	 */
	public void setModuleList(List<EhyModule> moduleList) {
		this.moduleList = moduleList;
	}
	/**
	 * 
	 * @return 模块ID
	 */
	public String getModId() {
		return modId;
	}
	/**
	 * 
	 * @param 模块ID
	 */
	public void setModId(String modId) {
		this.modId = modId == null ? null : modId.trim();
	}
	/**
	 * 
	 * @return 上级_模块ID
	 */
	public String getEhyModId() {
		return ehyModId;
	}
	/**
	 * 
	 * @param 上级_模块ID
	 */
	public void setEhyModId(String ehyModId) {
		this.ehyModId = ehyModId == null ? null : ehyModId.trim();
	}
	/**
	 * 
	 * @return 模块URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 
	 * @param 模块URL
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
	/**
	 * 
	 * @return 模块名称
	 */
	public String getModName() {
		return modName;
	}
	/**
	 * 
	 * @param 模块名称
	 */
	public void setModName(String modName) {
		this.modName = modName == null ? null : modName.trim();
	}
	/**
	 * 
	 * @return 模块编码
	 */
	public String getModCode() {
		return modCode;
	}
	/**
	 * 
	 * @param 模块编码
	 */
	public void setModCode(String modCode) {
		this.modCode = modCode == null ? null : modCode.trim();
	}
	/**
	 * 
	 * @return 模块说明
	 */
	public String getModDesc() {
		return modDesc;
	}
	/**
	 * 
	 * @param 模块说明
	 */
	public void setModDesc(String modDesc) {
		this.modDesc = modDesc == null ? null : modDesc.trim();
	}
	/**
	 * 
	 * @return 是否有效
	 */
	public Integer getIsva() {
		return isva;
	}
	/**
	 * 
	 * @param 是否有效
	 */
	public void setIsva(Integer isva) {
		this.isva = isva;
	}
	/**
	 * 
	 * @return 操作时间
	 */
	public Date getOptime() {
		return optime;
	}
	/**
	 * 
	 * @param 操作时间
	 */
	public void setOptime(Date optime) {
		this.optime = optime;
	}
	/**
	 * 
	 * @return 操作人
	 */
	public String getOper() {
		return oper;
	}
	/**
	 * 
	 * @param 操作人
	 */
	public void setOper(String oper) {
		this.oper = oper == null ? null : oper.trim();
	}
	/**
	 * 
	 * @return 排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 
	 * @param 排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 
	 * @return 上级模块
	 */
	public EhyModule getModule() {
		return module;
	}
	/**
	 * 
	 * @param module 上级模块
	 */
	public void setModule(EhyModule module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "EhyModule [modId=" + modId + ", ehyModId=" + ehyModId + ", url=" + url + ", modName=" + modName
				+ ", modCode=" + modCode + ", modDesc=" + modDesc + ", isva=" + isva + ", optime=" + optime + ", oper="
				+ oper + ", sort=" + sort + ", moduleList=" + moduleList + "]";
	}


}