package com.example.springbootapi.Controller;

import com.example.springbootapi.Entity.ChuyenBay;
import com.example.springbootapi.Entity.NhanVien;
import com.example.springbootapi.Service.ChuyenBayRepository;
import com.example.springbootapi.Service.MayBayRepository;
import com.example.springbootapi.Service.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ChuyenBayRepository chuyenBayRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Autowired
    MayBayRepository mayBayRepository;

    //Cau 1
    @RequestMapping(value = "/timchuyenbayboigaden/{gaden}", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDen(@PathVariable("gaden") String gaDen){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDen(gaDen);
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Cau 2
    @RequestMapping(value = "/maybaycotambaylonhon10000", method = RequestMethod.GET)
    public List<String> mayBayCoTamBayLonHon10000(){
        List<String> mayBays = mayBayRepository.findLoaiMayBayByTamBay();
        if(mayBays == null){
            ResponseEntity.notFound().build();
        }
        return mayBays;
    }
    //Cau 3
    @RequestMapping(value = "/timnhanvientheoluong", method = RequestMethod.GET)
    public List<NhanVien> timNhanVienTheoLuong(){
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByLuong();
        if(nhanViens == null){
            ResponseEntity.notFound().build();
        }
        return nhanViens;
    }
    //Cau 4
    @RequestMapping(value = "/timchuyenbayboidodai", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiDoDai(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByDoDai();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Cau 5
    @RequestMapping(value = "/timchuyenbayboigadenvagadi", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDenVaGaDi(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDiVaGaDen();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }
    //Cau 6
    @RequestMapping(value = "/sochuyenbayxuatphattusaigon/{gaDi}", method = RequestMethod.GET)
    public String soChuyenBayXuatPhatTuSaiGon(@PathVariable("gaDi") String gaDi){
        int soChuyenBay = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        if(soChuyenBay == 0){
            ResponseEntity.notFound().build();
        }
        return  "C?? " + soChuyenBay + " chuy???n bay xu???t ph??t t??? S??i G??n";
    }
    //Cau 7
    @RequestMapping(value = "/soloaimaybayboeing", method = RequestMethod.GET)
    public String soLoaiMayBayBoeing(){
        int soLoaiMayBay = mayBayRepository.findLoaiMayBay();
        if(soLoaiMayBay == 0){
            ResponseEntity.notFound().build();
        }
        return  "C?? " + soLoaiMayBay + " lo???i m??y bay Boeing";
    }
    //Cau 8
    @RequestMapping(value = "/tongsoluongnhanvien", method = RequestMethod.GET)
    public String tongSoLuongNhanVien(){
        int soLuong = nhanVienRepository.tinhTongLuong();
        if(soLuong == 0){
            ResponseEntity.notFound().build();
        }
        return  "T???ng s??? l????ng ph???i tr??? cho c??c nh??n vi??n l?? " + soLuong;
    }
    //Cau 9
    @RequestMapping(value = "/manhanvienlaimaybayboeing", method = RequestMethod.GET)
    public List<String> maNhanVienLaiMayBayBoeing(){
        List<String> maNhanViens = nhanVienRepository.getMaByLoaiMayBay();
        if(maNhanViens == null){
            ResponseEntity.notFound().build();
        }
        return  maNhanViens;
    }
    //Cau 10
    @RequestMapping(value = "/nhanvienlaimaybay747/{maMB}", method = RequestMethod.GET)
    public List<NhanVien> nhanVienLaiMayBay747(@PathVariable("maMB") int maMB){
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByMaMB(maMB);
        if(nhanViens == null){
            ResponseEntity.notFound().build();
        }
        return  nhanViens;
    }
    //Cau 11
    @RequestMapping(value = "/timmamaybaytheoho/{hoNV}", method = RequestMethod.GET)
    public List<Integer> nhanVienLaiMayBay747(@PathVariable("hoNV") String hoNV){
        List<Integer> maMayBays = mayBayRepository.getMaMBByTenNV(hoNV);
        if(maMayBays == null){
            ResponseEntity.notFound().build();
        }
        return  maMayBays;
    }
    //Cau 12
    @RequestMapping(value = "/maphicongvualaiboeingvaairbus", method = RequestMethod.GET)
    public List<String> maPhiCongVuaLaiBoeingVuaLaiAirbus(){
        List<String> maPhiCongs = nhanVienRepository.getMaByLoaiMB();
        if(maPhiCongs == null){
            ResponseEntity.notFound().build();
        }
        return  maPhiCongs;
    }
   // Cau 13
    @RequestMapping(value = "/loaimaybaydichuyenvn280/{maCB}", method = RequestMethod.GET)
    public List<String> maPhiCongVuaLaiBoeingVuaLaiAirbus(@PathVariable("maCB") String maCB){
        List<String> loaiMBs = mayBayRepository.loaiMayBayChuyenVN280(maCB);
        if(loaiMBs == null){
            ResponseEntity.notFound().build();
        }
        return  loaiMBs;
    }
    // Cau 14
    @RequestMapping(value = "/chuyenbaythuchienboiairbusa320/{loaiMB}", method = RequestMethod.GET)
    public List<ChuyenBay> chuyenBayThucHienBoiAirbusA320(@PathVariable("loaiMB") String loaiMB){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByMayBayAirbusA320(loaiMB);
        if(chuyenBays == null || chuyenBays.size() == 0){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 15
    @RequestMapping(value = "/phiconglaimaybayboeing", method = RequestMethod.GET)
    public List<String> phiCongLaiMayBayBoeing(){
        List<String> tenPhiCongs = nhanVienRepository.findTenNhanVienLaiBoeing();
        if(tenPhiCongs == null){
            ResponseEntity.notFound().build();
        }
        return  tenPhiCongs;
    }
    //Cau 16
    @RequestMapping(value = "/demsophiconglaimaybay", method = RequestMethod.GET)
    public List<Map<String, Object>> demSoPhiCongLaiMayBay(){
        List<Map<String, Object>> mayBays = mayBayRepository.demSoPhiCongLaiMayBay();
        if(mayBays== null){
            ResponseEntity.notFound().build();
        }
        return  mayBays;
    }
    //Cau 17
    @RequestMapping(value = "/timchuyenbayditugaadengabvelaigaa", method = RequestMethod.GET)
    public List<ChuyenBay> timCBDiTuGaADenBVeLaiA(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findCBDiTuGaADenBVeLaiA();
        if(chuyenBays== null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 18
    @RequestMapping(value = "/demchuyenbayditugaadenbvelaia", method = RequestMethod.GET)
    public List<Map<String, Object>> countCBDiTuGaADenBVeLaiGaA(){
        List<Map<String, Object>> chuyenBays = chuyenBayRepository.countCBDiTuGaADenBVeLaiA();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 19
    @RequestMapping(value = "/chiphichuyenbayditugaadenbvelaia", method = RequestMethod.GET)
    public List<Map<String, Object>> chiPhiCBDiTuGaADenBVeLaiGaA(){
        List<Map<String, Object>> chuyenBays = chuyenBayRepository.chiPhiCBDiTuGaADenBVeLaiA();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 20
    @RequestMapping(value = "/chuyenbaykhoihanhtruoc12h", method = RequestMethod.GET)
    public List<ChuyenBay> chuyenBayKhoiHanhTruoc12h(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayKhoiHanhTruoc12h();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 21
    @RequestMapping(value = "/soluongchuyenbaykhoihanhtruoc12h", method = RequestMethod.GET)
    public List<Map<String, Object>> soLuongChuyenBayKhoiHanhTruoc12h(){
        List<Map<String, Object>> chuyenBays = chuyenBayRepository.demChuyenBayKhoiHanhTruoc12h();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
    //Cau 22
    @RequestMapping(value = "/timphicongchilaibaloaimaybay", method = RequestMethod.GET)
    public List<String> timPhiCongChiLai3LoaiMB(){
        List<String> maPhiCongs = nhanVienRepository.findMaPhiCongLai3LoaiMayBay();
        if(maPhiCongs == null){
            ResponseEntity.notFound().build();
        }
        return  maPhiCongs;
    }
    //Cau 23
    @RequestMapping(value = "/mavatambaylonnhatcuaphiconglaihon3loaimaybay", method = RequestMethod.GET)
    public List<Map<String, Object>> maVaTamBayLonNhatVoiPhiCongLaiNhieuHonBaLoaiMayBay(){
        List<Map<String, Object>> maVaTamBays = nhanVienRepository.findMaNhanVienLai3LoaiMBVaTamBayLonNhat();
        if(maVaTamBays == null){
            ResponseEntity.notFound().build();
        }
        return  maVaTamBays;
    }
    //Cau 24
    @RequestMapping(value = "/phicongvasoluongmaybaycothelai", method = RequestMethod.GET)
    public List<Map<String, Object>> phiCongVoiSoLuongMBCoTheLai(){
        List<Map<String, Object>> phiCongVoiSoLuong = nhanVienRepository.phiCongVoiSoLuongMBCoTheLai();
        if(phiCongVoiSoLuong == null){
            ResponseEntity.notFound().build();
        }
        return  phiCongVoiSoLuong;
    }
    //Cau 25
    @RequestMapping(value = "/timnhanvienkhonglaphicong", method = RequestMethod.GET)
    public List<NhanVien> timNhanVienKhongPhaiLaPhiCong(){
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienKhongPhaiLaPhiCong();
        if(nhanViens == null){
            ResponseEntity.notFound().build();
        }
        return  nhanViens;
    }
    //Cau 26
    @RequestMapping(value = "/timnhanviencoluongcaonhat", method = RequestMethod.GET)
    public String timNhanVienMaxLuong(){
        String maNV = nhanVienRepository.findNhanVienCoMaxLuong();
        if(maNV == ""){
            ResponseEntity.notFound().build();
        }
        return  maNV;
    }
    //Cau 27
    @RequestMapping(value = "/tongluongchophicong", method = RequestMethod.GET)
    public String tongLuongChoCacPhiCong(){
        int luongPC = nhanVienRepository.tinhTongLuongChoPhiCong();
        if(luongPC == 0){
            ResponseEntity.notFound().build();
        }
        return  "T???ng l????ng c???a c??c phi c??ng l?? " + luongPC;
    }
    //Cau 28
    @RequestMapping(value = "/timchuyenbaythuchienboicacmaybayboeing", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayThucHienBoiTacCaMBBoeing(){
        List<ChuyenBay> chuyenBays = chuyenBayRepository.timChuyenBayThucHienBoiTacCaMBBoeing();
        if(chuyenBays == null){
            ResponseEntity.notFound().build();
        }
        return  chuyenBays;
    }
}
