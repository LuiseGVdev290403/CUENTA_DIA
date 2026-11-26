import { Routes } from '@angular/router';
import { AccountComponent } from './features/account-component/account-component';
import { StoreComponent } from './features/store-component/store-component';
import { CategoryComponent } from './features/category-component/category-component';
import { TagsComponent } from './features/tags-component/tags-component';

export const routes: Routes = [
  { path: '', redirectTo: 'compras', pathMatch: 'full' },
  { path: 'filtros/tiendas', component: StoreComponent },
  { path: 'filtros/cuentas', component: AccountComponent },
  { path: 'filtros/categorias', component: CategoryComponent },
  { path: 'filtros/etiquetas', component: TagsComponent },
];
