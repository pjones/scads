$fa = 1.0;
$fs = 0.5;
union () {
  cylinder (h=9, r1=27.75, r2=28.75, center=true);
  translate ([0, 0, 9/2]) {
    translate ([0, 0, 1/2]) {
      cylinder (h=1, r=31, center=true);
    }
  }
  translate ([0, 0, -9/2]) {
    translate ([0, 0, -9/2]) {
      difference () {
        union () {
          cylinder (h=9, r=27.75, center=true);
          translate ([0, 0, -9/2]) {
            cylinder (h=2.6, r1=29.137500000000003, r2=27.75, center=true);
          }
        }
        cylinder (h=11.6, r=26.45, center=true);
        union () {
          rotate (a=45.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=90.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=135.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=180.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=225.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=270.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
          rotate (a=315.0, v=[0, 0, 1]) {
            cube ([7.284375000000001, 58.275000000000006, 11.6], center=true);
          }
        }
      }
    }
  }
}
