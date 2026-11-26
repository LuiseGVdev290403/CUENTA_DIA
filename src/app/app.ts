import { Component, signal } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { AccountComponent } from './features/account-component/account-component';
import { StoreComponent } from './features/store-component/store-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  filtrosOpen = signal(false);
  toggleFiltros() {
    this.filtrosOpen.update((v) => !v);
  }
}
