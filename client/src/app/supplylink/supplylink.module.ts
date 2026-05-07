import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { SupplyLinkRoutingModule } from "./supplylink-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { ProductComponent } from "./components/product/product.component";
import { SupplierComponent } from "./components/supplier/supplier.component";
import { WarehouseComponent } from "./components/warehouse/warehouse.component";
import { SharedModule } from "../shared/shared.module";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { WarehouseEditComponent } from "./components/warehouseedit/warehouseedit.component";
import { SupplierEditComponent } from "./components/supplieredit/supplieredit.component";
import { LoginComponent } from "../auth/components/login/login.component";
import { LogoutComponent } from "../auth/components/logout/logout.component";
@NgModule({
  declarations: [
     ProductComponent,
    SupplierComponent,
    WarehouseComponent,
    DashboardComponent,
    WarehouseEditComponent,
    SupplierEditComponent
   
  ],
  imports: [
    CommonModule,
    SupplyLinkRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    
   
  ],
  exports: [
    
  ]
})
export class SupplyLinkModule {}