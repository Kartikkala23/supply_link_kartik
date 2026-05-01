import { Component } from '@angular/core';
import { Warehouse } from '../../types/Warehouse';

@Component({
  selector: 'app-warehousesample',
  standalone: true,
  imports: [],
  templateUrl: './warehousesample.component.html',
  styleUrls: ['./warehousesample.component.css'],
  template: 'Warehouse ID: {{warehouse.warehouseId}}<br>Supplier ID: {{warehouse.supplierId}}<br>Warehouse Name: ${{warehouse.warehouseName}}<br>Location: ${{warehouse.location}}<br>Capacity: ${{warehouse.capacity}}'
})
export class WarehouseSampleComponent {
  warehouse = new Warehouse(1, "2", "Flamingo", "Nevada", 1000);

}