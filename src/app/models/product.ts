export interface ProductRequest {
  name: string;
  description: string;
  price: number;
  unitMed: string;
  date: Date
}

export interface ProductResponse extends ProductRequest {
  id: number;
}
