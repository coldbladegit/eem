package com.warrior.eem.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warrior.eem.common.Result;
import com.warrior.eem.entity.SellPowerAgreement;
import com.warrior.eem.entity.vo.PageVo;
import com.warrior.eem.entity.vo.SellAgreementCdtVo;
import com.warrior.eem.entity.vo.SellPowerAgreementMonthDataUpateVo;
import com.warrior.eem.entity.vo.SellPowerAgreementUpdateVo;
import com.warrior.eem.service.SellPowerAgreementService;

/**
 * 售电合约 controller
 * 
 * @author seangan
 *
 */
@Controller
@RequestMapping("sell_agreement")
public class SellPowerAgreementController extends AbstractController {

	@Autowired
	private SellPowerAgreementService spaService;

	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> createEntity(SellPowerAgreementUpdateVo sellPowerAgreementUpdateVo,
			SellPowerAgreementMonthDataUpateVo sellPowerAgreementMonthVo,
			@RequestParam(name = "att_file", required = false) MultipartFile attrFile) {
		if (sellPowerAgreementUpdateVo != null && sellPowerAgreementUpdateVo.getId() != null
				&& sellPowerAgreementUpdateVo.getId().trim().length() > 0) { // update
			spaService.saveAndUpdateAgreement(attrFile, sellPowerAgreementUpdateVo, sellPowerAgreementMonthVo);
		} else { // create
			spaService.saveAndCreateAgreement(attrFile, sellPowerAgreementUpdateVo, sellPowerAgreementMonthVo);
		}
		return Result.success();
	}

	@RequestMapping(value = "info", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<Object> deleteEntity(String id) {
		spaService.deleteAgreement(convertId(id));
		return Result.success();
	}

	@RequestMapping(value = "info", method = RequestMethod.GET)
	@ResponseBody
	public Result<SellPowerAgreement> getEntity(String id) {
		return Result.success((SellPowerAgreement) spaService.getEntity(convertId(id)));
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> listEntities(@RequestBody(required = false) SellAgreementCdtVo cdt,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "per_page", required = false) String perPage) {
		Integer[] pageInfo = buildPageInfo(page, perPage);
		PageVo pv = spaService.listEntities(cdt, pageInfo[0], pageInfo[1]);
		return Result.success(pv.getCount(), pv.getDatas());
	}

}
