$fa = 1.0;
$fs = 0.5;
union () {
  difference () {
    union () {
      cylinder (h=3.25, r=92, center=true);
      translate ([-1.625, 0, 0]) {
        cube ([3.25, 195.25, 3.25], center=true);
      }
    }
    cylinder (h=3.25, r=86.375, center=true);
    translate ([46, 0, 0]) {
      cube ([92, 184, 3.25], center=true);
    }
  }
  translate ([-92, 0, 0]) {
    cube ([11.25, 22.5, 3.25], center=true);
  }
}
