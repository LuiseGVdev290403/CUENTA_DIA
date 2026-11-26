import { Component, EventEmitter, Output, Input, output, input } from '@angular/core';

@Component({
  selector: 'app-poput-store-component',
  imports: [],
  templateUrl: './poput-store-component.html',
  styleUrl: './poput-store-component.css',
})
export class PoputStoreComponent {
  isOpen = input(false);
  title = input('');
  closed = output<void>();

  onClose() {
    this.closed.emit();
  }

  onBackdropClick(event: MouseEvent) {
    if ((event.target as HTMLElement).id === 'popup-backdrop') {
      this.onClose();
    }
  }
}
