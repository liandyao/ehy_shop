/**
 * 
 */
package cn.ehuoyuan.shop.service.productImg;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyProductImgMapper;
import cn.ehuoyuan.shop.domain.EhyProductImg;

/**
 * 产品图片service实现接口
 * @author 欧阳丰
 * @data 2017年10月10日
 */
@Service
public class ProductImgServiceImpl implements ProductImgService{
	@Resource
	EhyProductImgMapper dao;
	
	@Override
	public int insert(EhyProductImg productImg) {
		return dao.insert(productImg);
	}

	@Override
	public int updateIsvaByProIdAndImgType(String proId, int imgType) {
		return dao.updateIsvaByProIdAndImgType(proId, imgType);
	}

	@Override
	public List<EhyProductImg> findImgByProIdAndImgType(String proId, int imgType) {
		return dao.findImgByProIdAndImgType(proId, imgType);
	}

	@Override
	public int findImgByProIdAndImgTypeSize(String proId, int imgType) {
		return dao.findImgByProIdAndImgTypeSize(proId, imgType);
	}

	@Override
	public int updateSortByImgId(String[] imgId,Integer[] sort) {
		for(int i =0;i<imgId.length;i++){
			EhyProductImg productImg = new EhyProductImg();
			productImg.setImgId(imgId[i]);
			productImg.setSort(sort[i]);
			dao.updateSortByImgId(productImg);
		}
		return 1;
	}

	@Override
	public int updateIsvaByImgId(String imgId) {
		EhyProductImg productImg = new EhyProductImg();
		productImg.setImgId(imgId);
		productImg.setIsva(0);
		int rows = dao.updateByPrimaryKeySelective(productImg);
		return rows;
	}

}
