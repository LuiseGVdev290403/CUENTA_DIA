export interface StoreRequest {
  name: string | null;
  description: string | null;
}

export interface StoreResponse extends StoreRequest {
  idStore: number | null;
}
