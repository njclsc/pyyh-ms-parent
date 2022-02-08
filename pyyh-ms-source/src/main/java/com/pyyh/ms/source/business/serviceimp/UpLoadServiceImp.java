package com.pyyh.ms.source.business.serviceimp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pyyh.ms.source.business.service.IUpLoadService;
import com.pyyh.ms.source.pojos.ResponsePojo;

@Service("UpLoadServiceImp")
public class UpLoadServiceImp implements IUpLoadService{
	@Override
	public String uploadSource(MultipartFile[] files, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<ResponsePojo> rps = new ArrayList<ResponsePojo>();
		String fn = "";
		try {
			String sourcePath = ResourceUtils.getURL("").getPath().substring(1) + "staticSource/";
			//单文件上传没问题，多文件上传一旦其中一个文件出现异常，此文件以后的都不成功。且返回信息会被最后一条覆盖
			for(MultipartFile file : files){
				try{
				ResponsePojo rp = new ResponsePojo();
				fn = file.getOriginalFilename();
				File f = new File(sourcePath + "/" + fn);
				if(!f.exists()){
					f.getParentFile().mkdirs();
					f.createNewFile();
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(file.getBytes());
					fos.flush();
					fos.close();
					rp.setMessage(fn + "上传成功!");
					rp.setState("success");
				}else{
					rp.setMessage(fn + "已存在!");
					rp.setState("fail");
				}
				rps.add(rp);
				}catch(Exception e){
					e.printStackTrace();
					ResponsePojo rp = new ResponsePojo();
					rp.setMessage(fn + "上传失败!");
					rp.setState("fail");
					rps.add(rp);
				}
			}
			return JSONArray.toJSONString(rps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResponsePojo rp = new ResponsePojo();
			rp.setMessage("资源定位异常");
			rp.setState("fail");
			return JSONObject.toJSONString(rp);
		}
		
	}

}
