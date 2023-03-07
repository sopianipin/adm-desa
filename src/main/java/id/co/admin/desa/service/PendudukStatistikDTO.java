package id.co.admin.desa.service;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendudukStatistikDTO {
    private BigInteger totalPenduduk;
    private BigInteger jumlahLakiLaki;
    private BigInteger jumlahPerempuan;
    private BigInteger jumlahKawin;
    private BigInteger jumlahBelumKawin;
}
