package com.zlinks.controller;
import com.zlinks.domain.OrdPayDetail;
import com.zlinks.service.OrdPayDetailService;
import com.zlinks.common.web.BaseController;
import com.zlinks.common.web.JsonResult;
import com.zlinks.common.web.PageResult;
import com.zlinks.common.web.RestDoing;
import com.zlinks.Routes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
/**
 * Copyright (C), 2017-2020, BBG
 * FileName: OrdPayDetailController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:16
 * Description: 控制层
 */
@RestController
@RequestMapping(value = Routes.API_VERSION)
public class OrdPayDetailController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private OrdPayDetailService ordPayDetailService;




	/**
     * @api {post} /ordPayDetails/save 01. OrdPayDetail删除
     * @apiPermission Login in Users
     * @apiGroup  OrdPayDetail
     * @apiVersion 1.0.1
	 * @apiParam {Number} id <code>必须参数</code> id
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/ordPayDetails/delete/{id}", method = RequestMethod.DELETE)
	public JsonResult deleteJson(@PathVariable("id") int id) {
		RestDoing doing = jsonResult -> {

            int counts = ordPayDetailService.delete(ordPayDetail);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /ordPayDetails/save 02. OrdPayDetail详细信息
     * @apiPermission Login in Users
     * @apiGroup  OrdPayDetail
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/ordPayDetails/info/{id}")
	public JsonResult info(@PathVariable("id") Long id) {

		RestDoing doing = jsonResult -> {

			OrdPayDetail entity  = ordPayDetailService.queryInfoById(id);
            jsonResult.data = entity;
        };
        return doing.go(request, logger);
	}

	/**
     * @api {post} /ordPayDetails/list 03. OrdPayDetail列表查询
     * @apiPermission Login in Users
     * @apiGroup  OrdPayDetail
     * @apiVersion 1.0.1
	 * @apiParam {Number} pageNo <code>必须参数</code> 页码，从1开始
	 * @apiParam {Number} pageSize <code>必须参数</code> 页码，每页显示的记录数量
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/ordPayDetails/list")
	public String list(String findContent, ModelMap modelMap, Integer pageNo) {
		try {
			Pagination<OrdPayDetail> data = ordPayDetailService.findPage(modelMap, pageNo, pageSize);
			modelMap.addAttribute("data", data);
		} catch (Exception e) {
			logger.error(HPXSConstants.ERROR_STRING, e);
			redirect404();
		}
		return BASE_PATH + "list";
	}


	/**
     * @api {post} /ordPayDetails/save 03. OrdPayDetail新增
     * @apiPermission Login in Users
     * @apiGroup  OrdPayDetail
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/ordPayDetails/save", method = RequestMethod.POST)
	public JsonResult add(@RequestBody OrdPayDetail ordPayDetail) {

  		RestDoing doing = jsonResult -> {

            int counts = ordPayDetailService.add(ordPayDetail);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}


	/**
     * @api {post} /ordPayDetails/update/{id} 03. OrdPayDetail修改
     * @apiPermission Login in Users
     * @apiGroup  OrdPayDetail
     * @apiVersion 1.0.1
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Date} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {BigInteger} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {String} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
	 * @apiParam {Integer} prop.propertyName <code>必须参数</code> OrdPayDetail的prop.propertyName
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 0,
     *     "data": 1
     *     "desc": "Success",
     *     "timestamp": "2018-7-9 19:08:16:082"
     * }
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 110002,
     *     "desc": "Param is null or error",
     *     "timestamp": "2018-7-9 19:08:16:479"
     * }
     */
	@RequestMapping(value = "/ordPayDetails/save", method = RequestMethod.PUT)
	public JsonResult add(@RequestBody OrdPayDetail ordPayDetail) {

  		RestDoing doing = jsonResult -> {

            int counts = ordPayDetailService.add(ordPayDetail);
            jsonResult.data = counts;
        };
        return doing.go(request, logger);
	}

}