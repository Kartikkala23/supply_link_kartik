import { Component } from '@angular/core';
import { Supplier } from '../../types/Supplier';
import { Warehouse } from '../../types/Warehouse';

@Component({
  selector: 'app-warehousesample',
  standalone: true,
  imports: [],
  templateUrl: './warehousesample.component.html',
  styleUrls: ['./warehousesample.component.css']
})
export class WarehouseSampleComponent {
  warehouse: Warehouse;

  constructor() {
    this.warehouse = new Warehouse(
      101,
      'SUP-001',
      'Central Warehouse',
      'Hyderabad',
      5000
    );
  }

}